<?php

	$phone_no=$_POST("");
	$name=$_POST("");
	$email=$_POST("");
	$address=$_POST("");
	$password=$_POST("");
	$online=$_POST("");
	$connection=mysqli_connnect("","","");
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	$cnt = mysql_num_rows(mysql_query("SELECT * FROM TABLE"));
	$query="insert into customer values(".$cnt.",".$name",".$email.",".$password.",".$phone_no.","$address",".$online.");"
	
	
?>