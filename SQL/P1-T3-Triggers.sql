CREATE OR REPLACE TRIGGER TR_ART_GRUP_DATACREACIO
BEFORE INSERT OR UPDATE ON ART_GRUP
FOR EACH ROW
BEGIN
    if :NEW.ART_GRUP_DATACREACIO > sysdate then
        RAISE_APPLICATION_ERROR(-20001, 'La data de creacio del grup no pot ser superior a la data actual.');
        end if;
end;
/

CREATE OR REPLACE TRIGGER TR_ART_IND_DATANAIX
BEFORE INSERT OR UPDATE ON ART_IND
FOR EACH ROW
BEGIN
    if :NEW.ART_IND_DATANAIX >= sysdate then
        RAISE_APPLICATION_ERROR(-20002, 'La data de naixement de l''artista no pot ser superior o igual a la data actual');
        end if;
end;
/

CREATE OR REPLACE TRIGGER TR_H_GRUP_DATAINICI
BEFORE INSERT OR UPDATE ON H_GRUP
FOR EACH ROW
BEGIN
    if:NEW.H_GRUP_DATAINICI > sysdate then
        RAISE_APPLICATION_ERROR(-20003, 'La data d''inici del grup no pot ser superior a la data actual.');
        end if;
end;
/

CREATE OR REPLACE TRIGGER TR_CANSO_ANYCREACIO
BEFORE INSERT OR UPDATE ON CANSO
FOR EACH ROW
BEGIN
    if :NEW.CANSO_ANYCREACIO > sysdate then
        RAISE_APPLICATION_ERROR(-20004, 'La data de creacio de la canco no pot ser superior a la data actual.');
        end if;
end;
/

CREATE OR REPLACE TRIGGER TR_ALBUM_ANYCREACIO
BEFORE INSERT OR UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    if :NEW.ALBUM_ANYCREACIO > sysdate then
        RAISE_APPLICATION_ERROR(-20005, 'L''any de creacio de l''album no pot ser superior al actual.');
        end if;
end;
/

CREATE OR REPLACE TRIGGER TR_CANSO_DURADA
BEFORE INSERT OR UPDATE ON CANSO
FOR EACH ROW
BEGIN
  IF (:new.canso_durada <= 0)
  THEN
    RAISE_APPLICATION_ERROR(-20006, 'La durada ha de ser major a 0.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_LLISTA_DURADA
BEFORE INSERT OR UPDATE ON LLISTA
FOR EACH ROW
BEGIN
  IF (:new.llista_durada < 0)
  THEN
    RAISE_APPLICATION_ERROR(-20007, 'La durada ha de ser major a 0.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_ALBUM_DURADA
BEFORE INSERT OR UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  IF (:new.album_durada < 0)
  THEN
    RAISE_APPLICATION_ERROR(-20008, 'La durada ha de ser major a 0.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_VIRTUAL_CLIENT_DELETE
BEFORE DELETE ON CLIENT
FOR EACH ROW
BEGIN
  IF (:old.client_id = 0)
  THEN
    RAISE_APPLICATION_ERROR(-20009, 'No es pot esborrar el client virtual.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_LLISTA_EN_UNA_LLISTA
BEFORE INSERT OR UPDATE ON LLISTA
FOR EACH ROW
DECLARE
  v_tipus cataleg.cataleg_tipus%type;
BEGIN
  SELECT cataleg_tipus INTO v_tipus FROM CATALEG WHERE cataleg_id = :new.llista_id;
  IF (v_tipus = 'L')
  THEN
    RAISE_APPLICATION_ERROR(-20010, 'No es pot inserir una llista dins de una altre llista.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_DELETE_CLIENT_UPDATE_REPRODUCCIO
BEFORE DELETE ON CLIENT
FOR EACH ROW
DECLARE
  rep_count number;
BEGIN
  SELECT COUNT(*) INTO rep_count FROM REPRODUCCIO WHERE reproduccio.reproduccio_id_client = :old.client_id;
  IF (rep_count > 0) THEN
    UPDATE REPRODUCCIO set reproduccio_id_client = 0 WHERE reproduccio_id_client = :old.client_id;
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_DELETE_PRODUCTE
BEFORE DELETE ON CATALEG
FOR EACH ROW
DECLARE
  rep_count number;
BEGIN
  SELECT COUNT(*) INTO rep_count FROM CATALEG where :old.cataleg_id IN (SELECT reproduccio_id_cataleg FROM REPRODUCCIO);
  if (rep_count > 0) then
    RAISE_APPLICATION_ERROR(-20011, 'No es pot esborrar un producte que ha estat reproduit.');
  END IF;
END;
/

CREATE OR REPLACE TRIGGER TR_DELETE_ARTISTA
BEFORE DELETE ON ARTISTA
FOR EACH ROW
DECLARE
  count1 number;
  count2 number;
begin
  SELECT COUNT (*) INTO count1 FROM CANSO where canso.canso_interpret = :old.artista_id;
  SELECT COUNT (*) INTO count2 FROM AUTORIA where autoria.autoria_id_artind = :old.artista_id;
  if (count1 > 0 or count2 > 0) THEN
    RAISE_APPLICATION_ERROR(-20012, 'No es pot esborrar un artista que sigui interpret o autor.');
  END IF;
end;
/

CREATE OR REPLACE TRIGGER TR_DURADA_ALBUM_CONTINGUT
AFTER INSERT OR DELETE OR UPDATE OF ALBUM_CONTINGUT_ID_CANSO ON ALBUM_CONTINGUT
FOR EACH ROW
DECLARE
  v_durada number(5);
  v_tipus char;
BEGIN
  if inserting or updating then
	SELECT cataleg_tipus INTO v_tipus FROM CATALEG WHERE cataleg_id = :new.album_contingut_id_album;
	IF (v_tipus = 'C') THEN
		SELECT canso_durada INTO v_durada FROM CANSO where canso_id = :new.album_contingut_id_canso;
		UPDATE ALBUM SET album_durada = album_durada + v_durada WHERE album_id = :new.album_contingut_id_album;
	END IF;
  end if;
  
  if deleting or updating then
    select cataleg_tipus into v_tipus from CATALEG where cataleg_id = :old.album_contingut_id_album;
    if (v_tipus = 'C') then
      select canso_durada into v_durada from CANSO where canso_id = :old.album_contingut_id_canso;
      update ALBUM set album_durada = album_durada - v_durada where album_id = :old.album_contingut_id_album;
    end if;
  end if;
END;
/
  
CREATE OR REPLACE TRIGGER TR_DURADA_ALBUM_AFTER_UPDATE_DURADA_CANSO
AFTER UPDATE OF canso_durada ON CANSO
FOR EACH ROW
DECLARE
BEGIN
  UPDATE ALBUM
  SET album_durada = album_durada - :old.canso_durada + :new.canso_durada
  WHERE album_id IN (SELECT album_contingut_id_album 
                     FROM ALBUM_CONTINGUT 
                     WHERE album_contingut_id_canso = :old.canso_id);
END;
/

CREATE OR REPLACE TRIGGER TR_DURADA_LLISTA_CONTINGUT
AFTER INSERT OR DELETE OR UPDATE OF llista_contingut_id_cataleg ON LLISTA_CONTINGUT
FOR EACH ROW
DECLARE
  v_durada number(5);
  v_tipus char;
BEGIN
  if INSERTING OR UPDATING THEN
    select cataleg_tipus into v_tipus from CATALEG where cataleg_id = :new.llista_contingut_id_cataleg;
    IF (v_tipus = 'C') THEN
      select canso_durada into v_durada from CANSO where canso_id = :new.llista_contingut_id_cataleg;
      update LLISTA set llista_durada = llista_durada + v_durada where llista_id = :new.llista_contingut_id_llista;
    END IF;
    IF (v_tipus = 'A') THEN
      select album_durada into v_durada from ALBUM where album_id = :new.llista_contingut_id_cataleg;
      update LLISTA set llista_durada = llista_durada + v_durada where llista_id = :new.llista_contingut_id_llista;
    END IF;
  END IF;

  if DELETING OR UPDATING then
    select cataleg_tipus into v_tipus from CATALEG where cataleg_id = :old.llista_contingut_id_cataleg;
    if (v_tipus = 'C') then
      select canso_durada into v_durada from CANSO where canso_id = :old.llista_contingut_id_cataleg;
      update LLISTA set llista_durada = llista_durada - v_durada where llista_id = :old.llista_contingut_id_llista;
    end if;
    if (v_tipus = 'A') then
      select album_durada into v_durada from ALBUM where album_id = :old.llista_contingut_id_cataleg;
      update LLISTA set llista_durada = llista_durada - v_durada where llista_id = :old.llista_contingut_id_llista;
    end if;
  end if;
END;
/

CREATE OR REPLACE TRIGGER TR_DURADA_LLISTA_AFTER_UPDATE_DURADA_CANSO
AFTER UPDATE OF canso_durada ON CANSO
FOR EACH ROW
DECLARE
BEGIN
  UPDATE LLISTA
  SET llista_durada = llista_durada - :old.canso_durada + :new.canso_durada
  WHERE llista_id IN (SELECT llista_contingut_id_llista 
                      FROM LLISTA_CONTINGUT 
                      WHERE llista_contingut_id_cataleg = :old.canso_id);
END;
/

CREATE OR REPLACE TRIGGER TR_DURADA_LLISTA_AFTER_UPDATE_DURADA_ALBUM AFTER UPDATE OF album_durada ON ALBUM
FOR EACH ROW
DECLARE
BEGIN
  UPDATE LLISTA
  SET llista_durada = llista_durada - :old.album_durada + :new.album_durada
  WHERE llista_id IN (SELECT llista_contingut_id_llista 
                      FROM LLISTA_CONTINGUT 
                      WHERE llista_contingut_id_cataleg = :old.album_id);
END;
