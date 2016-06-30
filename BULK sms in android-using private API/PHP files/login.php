<?php
include('db_config.php');
$s_name=$_POST["username"];
$s_number=$_POST["password"];

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
//echo "Connected successfully";
if($s_name==''||$s_number==''){
	echo 'Please Fill The Fileds';
}
else{
	 
     $sql = "SELECT * FROM sample WHERE name='$s_name' AND number='$s_number'";

//executing query
		$result = mysqli_query($conn,$sql);
		
		//fetching result
		$check = mysqli_fetch_array($result);
		
		//if we got some result 
		if(isset($check)){
			//displaying success 
			echo "success";
		}else{
			//displaying failure
			echo "failure";
		}
		mysqli_close($conn);
}
?>