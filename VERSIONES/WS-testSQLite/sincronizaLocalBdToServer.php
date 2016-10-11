
<?php
include 'conn.php';
header('content-type: application/json');

$get = json_decode(stripslashes($_POST['req']));

foreach($get as $usuario) {
		$UserName= $usuario -> UserName;
		$FullName= $usuario -> FullName;

	$getData="BEGIN TRANSACTION insertInto
				BEGIN TRY
					INSERT INTO dbo.usuarios (UserName,FullName)
						VALUES ('".utf8_decode($UserName)."','".utf8_decode($FullName)."')
				COMMIT TRANSACTION insertInto
				END TRY
				BEGIN CATCH
				  ROLLBACK TRANSACTION insertInto
				END CATCH ";


		$stmt = sqlsrv_query( $conn, $getData);
		if( $stmt === false ) {
		     die( print_r( sqlsrv_errors(), true));
		     $json=$get;
		     echo json_encode($json,true);
		}
		else{

			//$json = array("nombre" =>$UserName,"apellido" =>$FullName);
		//$msg[] = array("MENSAJE" =>"correcto!");
			$json=$usuario;
			
			echo json_encode($json,true);

		}
//$json=$get;
// $json = array("nombre" =>$UserName,"apellido" =>$FullName);
		
 //$json = $msg;

}
sqlsrv_close($conn);
 
?>