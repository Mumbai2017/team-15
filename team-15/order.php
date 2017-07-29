<?php

	$lat_customer=$_POST("");
	$long_customer=$_POST("");
	
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	$q1="select lat,long from sakhi where lat>=long && && && &&";
	
	
	
	$cnt = mysql_num_rows(mysql_query("SELECT * FROM TABLE"));
	$query="insert into customer values(".$cnt.",".$name",".$email.",".$password.",".$phone_no.","$address",".$online.");"
	
	
?>