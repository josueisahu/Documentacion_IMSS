<?php
include 'conn.php';

$getData = "select * from usuarios"; 

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt === false ) {
     die( print_r( sqlsrv_errors(), true));
}

while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
	$msg[]= array("idusers" => $row['idusers'],
	"UserName" => utf8_encode($row['UserName']), 
	"FullName" => utf8_encode($row['FullName']));

}
$json = $msg;

header('content-type: application/json');
echo json_encode($json);

 
sqlsrv_close($conn);
 
?>