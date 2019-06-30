<?php
	$username =$_GET['username'];
	$password =$_GET['password'];

	include('Connection.php');

	$sql="SELECT id FROM user WHERE username = '$username' AND password = '$password'";	
		
	$res = mysqli_query($con,$sql);

	$row = mysqli_fetch_row($res);
	   if (isset($row))
		   echo $row[0];
	mysqli_free_result($res);
	mysqli_close($con);
?>