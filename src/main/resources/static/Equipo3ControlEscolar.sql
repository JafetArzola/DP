CREATE TABLE Alumno(
idAlumno NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
apellidoPaterno VARCHAR(50) NOT NULL,
apellidoMaterno VARCHAR(50)NOT NULL
);

CREATE TABLE Materia(
idMateria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre VARCHAR(50)NOT NULL,
costo NUMBER (10, 2) NOT NULL
);

CREATE TABLE AlumnoMateria(
idAlumnoMateria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
idAlumno NUMBER NOT NULL,
FOREIGN KEY (idAlumno) REFERENCES Alumno(idAlumno),
idMateria NUMBER NOT NULL,
FOREIGN KEY (idMateria) REFERENCES Materia(idMateria)
);
//Insert para Alumno
INSERT INTO Alumno (nombre, apellidoPaterno, apellidoMaterno) VALUES ('Ejemplo1', 'Ejemplo1', 'Ejemplo1' );
INSERT INTO Alumno (nombre, apellidoPaterno, apellidoMaterno) VALUES ('Ejemplo2', 'Ejemplo2', 'Ejemplo2' );
INSERT INTO Alumno (nombre, apellidoPaterno, apellidoMaterno) VALUES ('Ejemplo3', 'Ejemplo3', 'Ejemplo3' );
//Insert para Materia
INSERT INTO Materia (nombre, costo) VALUES ('Materia1', 50.00);
INSERT INTO Materia (nombre, costo) VALUES ('Materia2', 75.50);
INSERT INTO Materia (nombre, costo) VALUES ('Materia3', 60.25);
//Insert para AlumnoMateria
INSERT INTO AlumnoMateria(idAlumno, idMateria)VALUES(1, 1);
INSERT INTO AlumnoMateria(idAlumno, idMateria)VALUES(2, 2);
INSERT INTO AlumnoMateria(idAlumno, idMateria)VALUES(3, 3);
----------------------------------------------------------------------------------------------------------------
//SP para Add de Alumno
CREATE OR REPLACE PROCEDURE AddAlumnoSP (
    p_nombre IN VARCHAR2,
    p_apellido_paterno IN VARCHAR2,
    p_apellido_materno IN VARCHAR2
)
AS
BEGIN
   
    INSERT INTO Alumno (nombre, apellidoPaterno, apellidoMaterno)
    VALUES (p_nombre, p_apellido_paterno, p_apellido_materno);

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
    
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddAlumnoSP;
--Para probar el Add
EXEC AddAlumnoSP('NombrePrueba', 'ApellidoPaternoPrueba', 'ApellidoMaternoPrueba');

----------------------------------------------------------------------------------------------------------------

//SP para Update de Alumno
CREATE OR REPLACE PROCEDURE UpdateAlumnoSP (
    p_id_alumno IN NUMBER,
    p_nombre IN VARCHAR2,
    p_apellido_paterno IN VARCHAR2,
    p_apellido_materno IN VARCHAR2
)
AS
BEGIN

    UPDATE Alumno
    SET nombre = p_nombre,
        apellidoPaterno = p_apellido_paterno,
        apellidoMaterno = p_apellido_materno
    WHERE idAlumno = p_id_alumno;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN

        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateAlumnoSP;
--Probar el SP de update 
EXEC UpdateAlumnoSP(1, 'NuevoNombre', 'NuevoApellidoPaterno', 'NuevoApellidoMaterno');

----------------------------------------------------------------------------------------------------------------

//SP para Delete de Alumno
CREATE OR REPLACE PROCEDURE DeleteAlumnoSP (
    p_id_alumno IN NUMBER
)
AS
BEGIN

    DELETE FROM Alumno WHERE idAlumno = p_id_alumno;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN

        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END DeleteAlumnoSP;
--Probar el SP
EXEC DeleteAlumnoSP(4);

----------------------------------------------------------------------------------------------------------------

//SP para GetAll de Alumno
CREATE OR REPLACE PROCEDURE GetAllAlumnoSP (
    p_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_cursor FOR
        SELECT * FROM Alumno;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END GetAllAlumnoSP;
-- Declarar el cursor
VAR result_set REFCURSOR;
-- Ejecutar el procedimiento almacenado
EXEC GetAllAlumnoSP(:result_set);
-- Mostrar los resultados
PRINT result_set;

----------------------------------------------------------------------------------------------------------------

//SP para GetById de Alumno.
CREATE OR REPLACE PROCEDURE GetByIdAlumnoSP (
    p_id_alumno IN NUMBER,
    p_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_cursor FOR
        SELECT * FROM Alumno WHERE idAlumno = p_id_alumno;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END GetByIdAlumnoSP;

VAR result_set REFCURSOR;

-- Ejecutar el procedimiento almacenado para obtener el alumno con id 1
EXEC GetByIdAlumnoSP(3, :result_set);

-- Mostrar los resultados
PRINT result_set;

----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------

//SP para Add de Materia.
CREATE OR REPLACE PROCEDURE AddMateriaSP (
    p_nombre IN VARCHAR2,
    p_costo IN NUMBER
)
AS
BEGIN

    INSERT INTO Materia (nombre, costo)
    VALUES (p_nombre, p_costo);

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN

        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddMateriaSP;

----------------------------------------------------------------------------------------------------------------

//SP para Update de Materia.
CREATE OR REPLACE PROCEDURE UpdateMateriaSP (
    p_id_materia IN NUMBER,
    p_nombre IN VARCHAR2,
    p_costo IN NUMBER
)
AS
BEGIN
    UPDATE Materia
    SET nombre = p_nombre,
        costo = p_costo
    WHERE idMateria = p_id_materia;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateMateriaSP;

----------------------------------------------------------------------------------------------------------------

//SP para Delete de Materia.
CREATE OR REPLACE PROCEDURE DeleteMateriaSP (
    p_id_materia IN NUMBER
)
AS
BEGIN
    DELETE FROM Materia WHERE idMateria = p_id_materia;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END DeleteMateriaSP;

----------------------------------------------------------------------------------------------------------------

//SP para GetAll de Materia.
CREATE OR REPLACE PROCEDURE GetAllMateriaSP (
    p_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_cursor FOR
        SELECT * FROM Materia;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END GetAllMateriaSP;

----------------------------------------------------------------------------------------------------------------

//SP para GetbyId de Materia.
CREATE OR REPLACE PROCEDURE GetByIdMateriaSP (
    p_id_materia IN NUMBER,
    p_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_cursor FOR
        SELECT * FROM Materia WHERE idMateria = p_id_materia;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END GetByIdMateriaSP;

----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------

//SP para Add de AlumnoMateria.
CREATE OR REPLACE PROCEDURE AddAlumnoMateriaSP (
    p_id_alumno IN NUMBER,
    p_id_materia IN NUMBER
)
AS
BEGIN
    INSERT INTO AlumnoMateria (idAlumno, idMateria)
    VALUES (p_id_alumno, p_id_materia);

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddAlumnoMateriaSP;
--Prueba
EXECUTE AddAlumnoMateriaSP(3, 3);

----------------------------------------------------------------------------------------------------------------

//SP para Update de AlumnoMateria.
CREATE OR REPLACE PROCEDURE UpdateAlumnoMateriaSP (
    p_id_alumno_materia IN NUMBER,
    p_id_alumno IN NUMBER,
    p_id_materia IN NUMBER
)
AS
BEGIN
    UPDATE AlumnoMateria
    SET idAlumno = p_id_alumno,
        idMateria = p_id_materia
    WHERE idAlumnoMateria = p_id_alumno_materia;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateAlumnoMateriaSP;

----------------------------------------------------------------------------------------------------------------

//SP para Delete de AlumnoMateria.
CREATE OR REPLACE PROCEDURE DeleteAlumnoMateriaSP (
    p_id_alumno_materia IN NUMBER
)
AS
BEGIN
    DELETE FROM AlumnoMateria WHERE idAlumnoMateria = p_id_alumno_materia;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END DeleteAlumnoMateriaSP;
--Prueba 
EXECUTE DeleteAlumnoMateriaSP(4); 


