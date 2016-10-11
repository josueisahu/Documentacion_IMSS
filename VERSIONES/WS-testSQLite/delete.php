<?php
include 'conn.php';
//Delete record from database


$idusers = $_POST['idusers']; 
$UserName = $_POST['UserName'];
$FullName = $_POST['FullName'];
//$status = $_POST['status'];
//$query = "DELETE FROM `user` WHERE   `name`='$name' && email = '$email'";
$query = "DELETE FROM users WHERE   UserName='".$UserName."'";
/*if ($connection->query($query)) {
    $msg = array("status" =>1 , "msg" => "Record Deleted successfully");
} else {
    echo "Error: " . $query . "<br>" . mysqli_error($connection);
}
*/ 


if ($conn) {
	$stmt = sqlsrv_query( $conn, $query);
	if( $stmt === false )
	{
	     die( print_r( sqlsrv_errors(), true));
	}
	$result=sqlsrv_free_stmt( $stmt);
	$msg = array("status" =>1 , "msg" => "Record Deleted successfully");
}
else 
{
	echo "Error: " . $query . "<br>" . sqlsrv_error();
}



$json = $msg;

header('content-type: application/json');
echo json_encode($json);


sqlsrv_close($conn);
 
?>