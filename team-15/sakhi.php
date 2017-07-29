<?php

	$name=check($_POST(""));
	$email=check($_POST(""));
	$password=check($_POST(""));
	$phone_no=check($_POST(""));
	$online=check($_POST(""));
	$lat=require(address.php);
	$long=check($_POST(""));
	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	$cnt = mysql_num_rows(mysql_query("SELECT * FROM TABLE"));
	$query="insert into customer values("",".$name",".$email.",".$password.",".$phone_no.","$address",".$online.","$lat",".$long.");"

	function check(m){
			
	  $data = trim($data);
	  $data = stripslashes($data);
	  $data = htmlspecialchars($data);
	  return $data;		
	}
?>