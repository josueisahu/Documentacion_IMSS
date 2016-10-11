<?php

$serverName = "LUNAPOON";
$connectionInfo = array( "Database"=>"INVENTARIOCDINEW", "UID"=>"sa", "PWD"=>"123"); 
$conn = sqlsrv_connect( $serverName, $connectionInfo) or die(sqlsrv_error());
?>