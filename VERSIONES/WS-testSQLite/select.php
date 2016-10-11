<?php
include 'conn.php';

//------------------------USUARIOS----------------------------------
$getData = "select * from Usuarios where bandera=1"; 
$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
$Usuarios[]= array("Login" => $row['Login'],
	"Password" => $row['Password'], 
	"nombre" => utf8_encode($row['nombre']));
}
$usuariosJson = array("Usuarios"=> $Usuarios);

//--------------------UNIDADES-----------------------------------
$getData = "select NumeroUnidad, encargado from Unidades where bandera=1"; 
$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Unidades[]= array("NumeroUnidad" => $row['NumeroUnidad'],
	"Encargado" =>utf8_encode( $row['encargado']));
}
$UnidadesJson = array("Unidades"=> $Unidades);

//----------------------------AREAS----------------------------------
			
$getData = "select CodDepartamento,Descripcion from Areas where bandera=1"; 
$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Areas[]= array("CodDepartamento" => $row['CodDepartamento'],
	"Descripcion" =>utf8_encode( $row['Descripcion']));
}
$areasJson = array("Areas"=> $Areas);

//-------------------------DEPTO-AREAS----------------------------------
$getData = "select id,idUnidad,depto,area from Depto_Areas"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Depto_Areas[]= array("id" => $row['id'],"idUnidad" => $row['idUnidad'],
		"depto" => $row['depto'],"area" =>utf8_encode( $row['area']));
}
$DeptoAreasJson = array("Depto_Areas"=> $Depto_Areas);

//-------------------- DETALLE EQUIPOS-------------------------------
$getData = "select id,serie,ip,macaddress,
					host,observaciones,extension,matricula,
					nombre,apellidopaterno,apellidomaterno,
					puesto,impresora,observacionImpresora 
			from detalleEquipos "; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$detalleEquipos[]= array("id" => $row['id'],
					"serie" => utf8_encode($row['serie']),
					"ip" => utf8_encode($row['ip']),
					"macaddress" =>utf8_encode($row['macaddress']),
					"host" => utf8_encode($row['host']),
					"observaciones" =>utf8_encode( $row['observaciones']),
					"extension" => utf8_encode($row['extension']),
					"matricula" => utf8_encode($row['matricula']),
					"nombre" => utf8_encode($row['nombre']),
					"apellidopaterno" =>utf8_encode($row['apellidopaterno']),
					"apellidomaterno" =>utf8_encode($row['apellidomaterno']),
					"puesto" =>utf8_encode($row['puesto']),
					"impresora" =>utf8_encode($row['impresora']),
					"observacionImpresora" =>utf8_encode($row['observacionImpresora']));
}

$detalleEquiposJson = array("detalleEquipos"=> $detalleEquipos);

//-------------------------MARCAS----------------------------------------------
$getData = "select clave, nombre from Marcas where bandera=1"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Marcas[]= array("clave" => $row['clave'],
			"nombre" => utf8_encode($row['nombre']));
}

$MarcasJson = array("Marcas"=> $Marcas);

//-------------------------DISPOSITIVOS----------------------------------------------
$getData = "select * from Dispositivos"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Dispositivos[]= array("clave" => $row['clave'],
	"nombre" => $row['nombre']);
}
$DispositivosJson = array("Dispositivos"=> $Dispositivos);

//------------------------MODELOS-----------------------------------------------
$getData = "select id, nombre, idDispositivo,idMarca from Modelos where bandera=1"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Modelos[]= array("id" => $row['id'],
				"nombre" => utf8_encode($row['nombre']),
				"idDispositivo" => $row['idDispositivo'],
				"idMarca" => $row['idMarca']);
}

$ModelosJson = array("Modelos"=> $Modelos);

//-----------------------EQUIPOS---------------------------------------------
$getData = "select numeroSerie,numeroInventario,idModelo,status
			from Equipos where bandera=1"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Equipos[]= array("numeroSerie" => utf8_encode($row['numeroSerie']),
	"numeroInventario" =>utf8_encode($row['numeroInventario']),
	"idModelo" => $row['idModelo'],"status" => $row['status']);
}
$EquiposJson = array("Equipos"=> $Equipos);

//-------------------CATEGORIAS---------------------------------
$getData = "select * from Categorias"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Categorias[]= array("id" => $row['Id'],
	"clave" => $row['Clave'], 
	"descripcion" => $row['Descripcion']);
}
$CategoriasJson = array("Categorias"=> $Categorias);

//-------------------TRABAJADORES----------------------------
$getData = "select Matricula,Nombre,Puesto from Trabajadores"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Trabajadores[]= array("matricula" => $row['Matricula'],
	"nombre" => utf8_encode($row['Nombre']), 
	"puesto" => $row['Puesto']);
}
$TrabajadoresJson = array("Trabajadores"=> $Trabajadores);

//-------------------SWITCHERS----------------------------
$getData = "select id,mdf,numMdf,rack,numRack from Switchers"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$Switchers[]= array("id" => $row['id'],
				"mdf" => $row['mdf'], 
				"numMdf" => $row['numMdf'], 
				"rack" => $row['rack'],
				"numRack" => $row['numRack']);
}
$SwitchersJson = array("Switchers"=> $Switchers);

//--------------------DETALLESWITCHER---------------------------------

$getData = "select serie,idSwitcher,numero,propiedad 
			from DetalleSwitcher"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$DetalleSwitcher[]= array("serie" => $row['serie'],
				"idSwitcher" => $row['idSwitcher'], 
				"numero" => $row['numero'], 
				"propiedad" => $row['propiedad']);
}
$DetalleSwitcherJson = array("DetalleSwitcher"=> $DetalleSwitcher);

//----------------------FOTOCONDUCTORES------------------------
$getData = "select id,descripcion,rendimiento from FotoConductores"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$FotoConductores[]= array("id" => $row['id'],
				"descripcion" => $row['descripcion'], 
				"rendimiento" => $row['rendimiento']);
}
$FotoConductoresJson = array("FotoConductores"=> $FotoConductores);

//------------------IMPRESORAS CONTADORES------------------------
$getData = "select folio,serie,idFotoconductor,contador 
			from ImpresorasContadores"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt == false ) {
     die( print_r( sqlsrv_errors(), true));
}
while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$ImpresorasContadores[]= array("folio" => $row['folio'],
				"serie" => $row['serie'], 
				"idFotoconductor" => $row['idFotoconductor'],
				"contador" => $row['contador']);
}
$ImpresorasContadoresJson = array("ImpresorasContadores"=> $ImpresorasContadores);

//------------------------JSON A ENVIAR-----------------------------------------------
$json = array($usuariosJson,$UnidadesJson,$areasJson,$DeptoAreasJson,$detalleEquiposJson,
	$MarcasJson,$DispositivosJson,$ModelosJson,$EquiposJson,$CategoriasJson,
	$TrabajadoresJson,$SwitchersJson,$DetalleSwitcherJson,$FotoConductoresJson,
	$ImpresorasContadoresJson);

	//$json = $usuariosJson;
header('content-type: application/json');
echo json_encode($json);
sqlsrv_close($conn);
 
?>