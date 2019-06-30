<?php

	$username = $_GET['username'];
	$password = $_GET['password'];	

	include('Connection.php');

	$sql="INSERT INTO user VALUES (NULL, '$username', '$password');";

	if(!$result=mysqli_query($con, $sql)) echo mysqli_error($con);
	else echo "User Registered Successfully!";
	mysqli_close($con);
	
?>