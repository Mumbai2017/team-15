<?php

	$startlat=$_POST("");
	$startlng=$_POST("");
	
	if(!$connection){
		die("Data connection failed".mysqli_error($connection));
	}
	$select_db=mysqli_select_db('');
	if(!$select_db){
		die("Database connection failed".mysql_error($select_db));
	}
	
	
	
	
	$query="SELECT ID,SQRT(
    POW(69.1 * (latitude - [$startlat]), 2) +
    POW(69.1 * ([$startlng] - longitude) * COS(latitude / 57.3), 2)) AS distance
	FROM CUSTOMER HAVING distance < 200 ORDER BY distance;"	
	
?>