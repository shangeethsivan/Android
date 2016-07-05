<?php
  include('db_config.php');

  if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  }
  $message=$_POST['message'];
		$names=$_POST['selected'];
		
		$name_array=explode(" ",$names);
		foreach($name_array as $selected){
  $query = "SELECT number FROM sample where name='$selected'";
    $result = mysqli_query($conn, $query);
      if($result) {
        $row = mysqli_fetch_row($result);
if($row!= null)		{
			$mobile=$row[0];
				$s = send_sms($mobile, $message);		
	  }
	  }   }
	  echo 'Successfull sent';
          function send_sms($mobile, $message) {
	         $purl='http://bulksmsgateway.co.in/SMS_API/sendsms.php?username=xxx&password=xxx&mobile=';// Enter your username and password if you buy the API here
																// Else replace the the url with the url give with your SMS Api Provider
	          $qurl='&sendername=SMSPRO&message=';
	           $rurl='&routetype=0';
	            $smsurl=$purl.$mobile.$qurl.urlencode($message).$rurl;
	             return file_get_contents($smsurl);
             }
 ?>
