<?php
include 'conn.php';


$get = json_decode(stripslashes($_POST['req']));

// Get data from object
$idusers = $get->idusers; 


//$getData = "select * from users"; 

//$getData = "select * from users where idusers = 1";
$getData ="select * from users where idusers=".$idusers;

$stmt = sqlsrv_query( $conn, $getData);
if( $stmt === false ) {
     die( print_r( sqlsrv_errors(), true));
}


//while($r = mysqli_fetch_assoc($qur)){

//while ($row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC)) {
$row = sqlsrv_fetch_array($stmt, SQLSRV_FETCH_ASSOC);
	$msg[]= array("idusers" => $row['idusers'],
	"UserName" => $row['UserName'], 
	"FullName" => $row['FullName']);
//}

$json = $msg;

header('content-type: application/json');
echo json_encode($json);

 
sqlsrv_close($conn);
?>