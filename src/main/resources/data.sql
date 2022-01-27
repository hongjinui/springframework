/*
    -------------------------------------------
    Type     : Table
    Name     : TB_USER
    Descript : user information
    -------------------------------------------
*/

INSERT INTO TB_USER(USR_SEQ, USR_ID, USR_PW, USR_NAME)
    VALUES (TB_USER_SEQ.NEXTVAL, 'aaa', '1234', 'hong');
INSERT INTO TB_USER(USR_SEQ, USR_ID, USR_PW, USR_NAME)
    VALUES (TB_USER_SEQ.NEXTVAL, 'bbb', '1234', 'park');
INSERT INTO TB_USER(USR_SEQ, USR_ID, USR_PW, USR_NAME)
    VALUES (TB_USER_SEQ.NEXTVAL, 'ccc', '1234', 'kim');

-- INSERT INTO TB_USER VALUES (1, 'aaa', '1234', 'hong');
-- INSERT INTO TB_USER VALUES (2, 'bbb', '1234', 'park');
-- INSERT INTO TB_USER VALUES (3, 'ccc', '1234', 'kim');

/*
    -------------------------------------------
    Type     : Table
    Name     : TB_AUTHORITY
    Descript : AUTHORITY information
    -------------------------------------------
*/

INSERT INTO TB_AUTHORITY(ATH_SEQ, USR_SEQ, AUTHORITY)
    VALUES (TB_AUTHORITY_SEQ.NEXTVAL, 1000, 'ADMIN');
INSERT INTO TB_AUTHORITY(ATH_SEQ, USR_SEQ, AUTHORITY)
    VALUES (TB_AUTHORITY_SEQ.NEXTVAL, 2000, 'USER');
INSERT INTO TB_AUTHORITY(ATH_SEQ, USR_SEQ, AUTHORITY)
    VALUES (TB_AUTHORITY_SEQ.NEXTVAL, 3000, 'USER');