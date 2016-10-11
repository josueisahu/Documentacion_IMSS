<?php
include 'conn.php';
//Update record in database

/*
$name = $_POST['name'];
$email = $_POST['email'];
$status = $_POST['status'];
$id = $_POST['id'];
*/



$idusers = $_POST['idusers']; 
$UserName = $_POST['UserName'];
$FullName = $_POST['FullName'];
//$status = $_POST['status'];
 

//$query = "UPDATE `user` SET `name`='$name' ,`email`='$email' WHERE  `id`='$id'";

$query = "UPDATE users SET UserName='".$UserName."',FullName='".$FullName."' WHERE idusers='".$idusers."'";
/*
if ($connection->query($query)) {
       $msg = array("status" =>1 , "msg" => "Record Updated successfully");
}else {
    echo "Error: " . $query . "<br>" . mysqli_error($connention);
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