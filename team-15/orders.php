<?php;
	$cust_id=$_POST['userId'];
	$address=$_POST['addr'];
	$billamount=$_POST['total'];
	$preference=1;
	$created_at=mktime();
	$conn = mysqli_connect($servername, $username, $password, $dbname);
	if(!$conn) {
		die("Connection failed" . mysqli_error());
	}
 	
 	$q="insert into orders values(null,'".$cust_id."','".$address."',".$billamount.",".$preference.",'".$created_at."')";
 	mysqli_query($conn, $q);
 	$sql = "select order_id from orders order by desc";
 	$order_id = mysqli_query($conn, $sql);;

 	$quantity  = $_POST['return'];
	$quantity = trim($quantity);
	if(strpos($quantity,' ') >= 0)
	{
		$pieces = explode(" ", $quantity);
		$i=0;
		for($i=0;$i<9;$i++) {
			if($quantity[$i] > 0)
			{
				$t = "insert into orders_quantity values('".$order_id.",".($i+1).",".$quantity[$i].")";
				mysqli_query($conn, $t);
			}	
		}
	}
?>