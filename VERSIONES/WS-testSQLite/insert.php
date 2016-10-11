<?php
include 'conn.php';


$get = json_decode(stripslashes($_POST['req']));
// Get data from object
$idusers = $get->idusers; 
$UserName =$get->UserName;
$FullName = $get->FullName;
 
$sql = "INSERT INTO usuarios (UserName,FullName) VALUES ('".$UserName."', '".$FullName."')";

if ($conn) {
	$stmt = sqlsrv_query( $conn, $sql);
	if( $stmt === false )
	{
	     die( print_r( sqlsrv_errors(), true));
	}
	$result=sqlsrv_free_stmt( $stmt);
}
else 
{
	echo "Error: " . $sql . "<br>" . sqlsrv_error();
}



/*
$stmt = sqlsrv_query( $conn, $sql);
if( $stmt === false ) {
     die( print_r( sqlsrv_errors(), true));
}
$result=sqlsrv_free_stmt( $stmt);
$msg = array("status" =>1 , "msg" => "Your record inserted successfully");
*/

 
//$json = $msg;
 
header('content-type: application/json');
//echo json_encode($json);
 
 
sqlsrv_close($conn);
 
?>