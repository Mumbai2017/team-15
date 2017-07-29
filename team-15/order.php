<?php 
	//session_start();
	//$id=$_SESSION["username"];
	$cust_id=$_POST("");
	$preference=$_POST("");
	$created_at=mktime();
	
	$q="insert into orders value('""','".cust_id."','".preference."','".created_at."')";
	
	
	
	
	
?>