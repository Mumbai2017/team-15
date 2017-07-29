  <?php
	$conn=mysqli_connect("localhost","root","","users");
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	
	} 
	//$que="select name from user where email='vinayp173@gmail.com' and pass='pass'";
	$que="select name from user where email='".$_POST['email']."' and pass='".$_POST['pass']."'";
	$res=mysqli_query($conn,$que);
	if($res->num_rows > 0){
		while($entry=mysqli_fetch_assoc($res)){
			echo $entry['name'];
		}
	}
	else{
		echo "no user exists";
	}
 ?>