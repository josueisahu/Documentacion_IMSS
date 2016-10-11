<?php
include 'conn.php';
//Select data from database



$get = json_decode(stripslashes($_POST['req']));

// Get data from object
$Table = $get->Table; 

$getData="insert into ServerDB.usuarios(UserName,FullName) 
			select UserName, FullName from ".$Table ;
echo $Table;
$stmt = sqlsrv_query( $conn, $getData);
if( $stmt === false ) {
     die( print_r( sqlsrv_errors(), true));
}

$msg[] = array("MENSAJE" =>"correcto!");
$json = $msg;

header('content-type: application/json');
echo json_encode($json);

 
sqlsrv_close($conn);
 
?>