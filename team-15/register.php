<?php

	$phone_no=check($_POST(""));
	$name=check($_POST(""));
	$email=check($_POST(""));
	$address=check($_POST(""));
	$password=check(md5($_POST("")));
	$online=check($_POST(""));
	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	$cnt = mysql_num_rows(mysql_query("SELECT * FROM TABLE"));
	$query="insert into customer values("null",".$name",".$email.",".$password.",".$phone_no.","$address",".$online.");"
	
	function check(m){
			
	  $data = trim($data);
	  $data = stripslashes($data);
	  $data = htmlspecialchars($data);
	  return $data;
	}
	
?>