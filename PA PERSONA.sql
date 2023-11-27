USE TRANSPORTE2
create PROC AddPersona(@codigo int,@ci int,@nombre varchar(100),@sexo char,@dir varchar(100),@telf int,@habilitado varchar(2),
@cargo varchar(15),@nroInt int,@categoria char,@disponble varchar(2),@tipoSocio varchar(4),@tipoChofer varchar(4),@tipoEmpledo varchar(4))
AS
BEGIN
	if @tipoChofer='null' and @tipoEmpledo='null'
	--socio
	begin
		if @cargo='null'
		begin
			BEGIN TRAN
			insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,null,
			@nroInt,null,'NO','S',null,null)
			COMMIT TRAN
			return
		end
		else 
		begin
			BEGIN TRAN
			insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,@cargo,
			@nroInt,null,null,'S',null,null)
			COMMIT TRAN
			return
		end
	end
	
	if @tipoSocio='null' and @tipoEmpledo='null'
	--chofer
	begin 
		if(select COUNT(nroint) from persona where nroInt=@nroInt and habilitado='SI')>=1
		begin
			begin tran
			update persona set disponble='NO' where nroInt=@nroInt and tipoSocio='S' and habilitado='SI'
			update persona set habilitado='NO' where nroInt=@nroInt and tipoSocio='S' and habilitado='SI'
			update persona set disponble='NO' where nroInt=@nroInt and tipoChofer='C' and habilitado='SI'
			update persona set habilitado='NO' where nroInt=@nroInt and tipoChofer='C' and habilitado='SI'
			insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,null, 
			@nroInt,@categoria,@disponble,null,'C',null)
			commit tran
			return
		end
		else
		begin
			BEGIN TRAN
			insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,null,
			@nroInt,@categoria,@disponble,null,'C',null)
			COMMIT TRAN
			return
		end
	end
	
	if @tipoSocio<>'null' and @tipoChofer<>'null'
	--socio chofer
		if @cargo='null'
		begin
			BEGIN TRAN
			insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,null,
										@nroInt,@categoria,@disponble,'S','C',null)
			COMMIT TRAN
			return
		end
		else
		begin
			BEGIN TRAN
			insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,@cargo,
										@nroInt,@categoria,@disponble,'S','C',null)
			COMMIT TRAN
			return
		end
	if @tipoSocio='null' and @tipoChofer='null'
	-- empleado
	begin
		BEGIN TRAN
		insert into persona values(@codigo,@ci,@nombre,@sexo,@dir,@telf,@habilitado,@cargo,
		@nroInt,null,@disponble,null,null,'E')
		COMMIT TRAN
		return
	end
	
END

EXEC AddPersona 1155,6033603,'MOISES MUÑOS U.','M','PLAN 3000',68022837,'SI','VENDEDOR',1,'A','NO','S','C','NULL'
SELECT *FROM persona WHERE  CODIGO=1202

create PROC AddCliente(@id int,@nombre varchar(100),@sexo varchar(1),@ci int)
as
	if @ci not in (select ci from cliente where ci=@ci)
	begin
		insert into cliente values(@id,@nombre,@sexo,@ci)
	end
	else
		raiserror ('EL CLIENTE YA ESTA REGISTRADO',16,1)
return

EXEC AddCliente 59,'SAULO J. GARCIA LIMA','M',null
SELECT *FROM cliente WHERE ID=59

create proc AddBoleto(@Nro int,@precio float ,@asiento int ,@codplanilla int ,@codEmpleado int,@ciCliente int)
as
	declare @idCliente int
	if @asiento NOT IN(select asiento from boleto where codplanilla=@codplanilla)
	begin
		if @ciCliente in (select ci from cliente where ci=@ciCliente)
		begin
			BEGIN TRAN
			set @idCliente=(select id from cliente where ci=@ciCliente)
			insert into boleto values (@Nro,@precio,@asiento,@codplanilla,@codEmpleado,@idCliente)
			COMMIT TRAN
		END
		else
			raiserror ('EL CLIENTE NO ESTA REGISTRADO',16,1)
	end
	else
		raiserror ('EL ASIENTO YA ESTA VENDIDO',16,1)
return
EXEC ADDBOLETO 49,25,7,8,1200,6033603
SELECT * FROM boleto
SELECT * FROM GUIA WHERE CODIGO=4

CREATE PROC AddEncomienda(@cod int,@descripcion varchar(50),@precio float,@cantidad int,@idGuia int)
as
	begin tran
	insert into encomienda values(@cod,@descripcion,@precio,@cantidad,@idGuia)
	update guia set costo=costo+(@precio*@cantidad) where codigo=@idGuia
	commit tran
return
exec addencomienda 6,'CAJAS DE MADERAS',5,3,4

CREATE PROC AddEquipaje(@cod int,@descripcion varchar(30),@precio float,@cantidad int,@idNota int)
as
	begin tran
		insert into equipaje values(@cod,@descripcion,@precio,@cantidad,@idNota)
		update nota set costo=costo+(@cantidad*@precio) where id=@idNota
	commit tran
return
exec addequipaje 104,'MALETAS',5,3,2	
select * from equipaje 
select * from nota WHERE ID=2

create PROC AddGuia(@codigo int, @fecha date, @costo float, @estadoDeCobro varchar(12),
					@codPlanilla int, @codEmpleado int, @ciEnvia int, @ciRecibe int)
as	
	declare @idE int
	declare @idR int
	begin tran
		if (@ciEnvia in (select ci from cliente where ci=@ciEnvia))
		and (@ciRecibe in (select ci from cliente where ci=@ciRecibe))
		begin
		    Set @idE=(select id from cliente where ci=@ciEnvia)
		    Set @idR=(select id from cliente where ci=@ciRecibe)
			insert into guia values (@codigo,@fecha,@costo,@estadoDeCobro,@codPlanilla,@codEmpleado,@idE,@idR)
		end
		else
		begin
			raiserror ('LOS CARNET DE IDENTIDAD NO ESTAN REGISTRADOS',16,1)
		end	
	commit tran
return 
SELECT * FROM GUIA
exec addguia 7,'2016-05-15',0,'CANCELADO',6,1005,6023602,6033603 select * from guia

create proc AddItinerario(@nro int,@fecha date,@hora time,@origen varchar(30),@destino varchar(30))
as	
	if @origen in (select nombre from lugar where nombre=@origen) and 
		@destino in (select nombre from lugar where nombre=@destino)
	begin
		declare @codO int
		declare @codD int
		declare @codRuta int
		set @codO=(select cod from lugar where nombre=@origen)
		set @codD=(select cod from lugar where nombre=@destino)
		set @codRuta=(select cod from ruta where codOrigen=@codO and codDestino=@codD)
		insert into itinerario values(@nro,@hora,@fecha,@codRuta)
	end
	else
		raiserror ('LOS LUGARES NO EXISTEN',16,1)
return
		delete itinerario where nro=32
exec AddItinerario 32,'2016-06-15','18:00:00','SANTA CRUZ','MONTERO'

create proc updateItinerario(@nro int,@fecha date,@hora time,@origen varchar(30),@destino varchar(30))
as
	if @origen in (select nombre from lugar where nombre=@origen) and 
		@destino in (select nombre from lugar where nombre=@destino)
	begin
		begin tran
		declare @codO int
		declare @codD int
		declare @codRuta int
		set @codO=(select cod from lugar where nombre=@origen)
		set @codD=(select cod from lugar where nombre=@destino)
		set @codRuta=(select cod from ruta where codOrigen=@codO and codDestino=@codD)
		update itinerario set hora=@hora where nro=@nro;
        update itinerario set fecha=@fecha where nro=@nro;
        update itinerario set codRuta=@codRuta where nro=@nro;
        commit tran
	end
	else
		raiserror ('DATOS INVALIDOS',16,1)
return

select * from itinerario
select * from lugar
select * from ruta
select nro,hora,fecha,l.nombre as Origen,lu.nombre as Destino from itinerario i, ruta r, lugar l, lugar lu
where r.cod=i.codRuta and r.codOrigen=l.cod and r.codDestino=lu.cod

create proc AddPlanilla(@cod int,@costoPlanilla float,@fecha date,@hora time,
            @totalPasaje float,@nroItinerario int,@codChofer int,@idVehiculo int)
as
	 if 1 in (select idEstado from vehiculo where id=@idVehiculo)
		BEGIN
		 if 'SI' in (select habilitado from persona where codigo=@codChofer)
		 	insert into planilla values(@cod,@costoPlanilla,@fecha,@hora,@totalPasaje,@codChofer,@idVehiculo,@nroItinerario)
		 else
		 	raiserror ('EL CHOFER NO ESTA HABILITADO',16,1)
		END
	 else
		raiserror ('EL VEHICULO NO ESTA HABILITADO',16,1)
return


create proc AddHojaDeLlegada(@id int,@hora time,@fecha date,@codPlanilla int)
as
	insert into hojaDellegada values(@id,@hora,@fecha,@codPlanilla)
return


create proc AddHojaDeSalida(@id int,@costo float,@hora time,@codPlanilla int)
as
	insert into hojaDeSalida values(@id,@costo,@hora,@codPlanilla)
return

create proc AddLugar(@cod int,@nombre varchar(30))
as
	if @nombre not in (select nombre from lugar where nombre=@nombre)
		BEGIN
			insert into lugar values(@cod,@nombre)
		END
	else
		raiserror ('EL LUGAR YA EXISTE',16,1)
return

create proc AddRuta(@cod int,@costo float,@tiempoDeViaje time,@Origen varchar(30),@Destino varchar(30))
as
	declare @codOrigen varchar(30)
	declare @codDestino varchar(30)
	set @codOrigen =(select cod from lugar where nombre=@Origen)
	set @codDestino =(select cod from lugar where nombre=@Destino)
	if @codOrigen >0
		begin
		if @codDestino>0
			insert into ruta values(@cod,@costo,@tiempoDeViaje,@codOrigen,@codDestino)
		else
			raiserror ('EL DESTINO NO EXISTE',16,1)
		end
	else
		raiserror ('EL ORIGEN NO EXISTE',16,1)
return

create proc updateRuta(@cod int,@costo float,@tiempoDeViaje time,@Origen varchar(30),@Destino varchar(30))
as
	declare @codOrigen varchar(30)
	declare @codDestino varchar(30)
	set @codOrigen =(select cod from lugar where nombre=@Origen)
	set @codDestino =(select cod from lugar where nombre=@Destino)
	if @codOrigen >0
		begin
		if @codDestino>0
			BEGIN
			begin tran
				update ruta set costo=@costo where cod=@cod
				update ruta set tiempoDeViaje=@tiempoDeViaje where cod=@cod
				update ruta set codOrigen=@codOrigen where cod=@cod
				update ruta set codDestino=@codDestino where cod=@cod
			commit tran
			END
		else
			raiserror ('EL DESTINO NO EXISTE',16,1)
		end
	else
		raiserror ('EL ORIGEN NO EXISTE',16,1)
return

create proc AddSeguro(@cod int , @tipoSeguro varchar(30))
as
	if @tipoSeguro not in (select tipoSeguro from seguro where tipoSeguro=@tipoSeguro)
		insert into seguro values(@cod,@tipoSeguro)
	else
		raiserror ('YA EXISTE UN SEGURO REGISTRADO CON EL MISMO NOMBRE',16,1)
return

-- TRIGGER---------------------------------------------------------------------TRIGGER
create trigger totalPasaje on boleto
for insert as
begin
	declare @codplanilla int
	declare @cantidadPasajero int
	declare @precio float
	set @codplanilla=(select codplanilla from inserted)
	set @cantidadPasajero=(select count(codplanilla) from boleto where codplanilla=@codplanilla)
	set @precio=(select precio from INSERTED)
	
	if @cantidadPasajero<=7
		update planilla set totalpasaje=totalpasaje+@precio where cod=@codplanilla
	else
		begin
--			print('LA PLANILLA ESTA LLENA')
			RAISERROR ('LA PLANILLA ESTA LLENA DE PASAJEROS',16,1)
			rollback tran
		end
end
select count(codplanilla) from boleto where codplanilla=6
SELECT * FROM BOLETO where codplanilla=6
INSERT INTO BOLETO VALUES(46,25,4,6,1200,37)
INSERT INTO BOLETO VALUES(47,25,4,6,1200,37)
INSERT INTO BOLETO VALUES(48,25,4,6,1200,37)
INSERT INTO BOLETO VALUES(49,25,4,6,1200,37)