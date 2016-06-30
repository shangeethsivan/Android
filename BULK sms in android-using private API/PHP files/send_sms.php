<?php
  include('db_config.php');

  if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
  }
  echo "Connected successfully";
  $query = "SELECT number FROM sample";
    $result = mysqli_query($conn, $query);
      if($result) {
        $message=$_POST['message'];
        while($row = mysqli_fetch_row($result)) {
        		$s = send_sms($row[0], $message);
        	}
          }
          function send_sms($mobile, $message) {
	         $purl='http://bulksmsgateway.co.in/SMS_API/sendsms.php?username=xxx&password=xxx&mobile=';// Enter your username and password if you buy the API here
																// Else replace the the url with the url give with your SMS Api Provider
	          $qurl='&sendername=SMSPRO&message=';
	           $rurl='&routetype=0';
	            $smsurl=$purl.$mobile.$qurl.urlencode($message).$rurl;
	             return file_get_contents($smsurl);
             }
 ?>
