<?php
require_once __DIR__ . '/vendor/autoload.php';
$base = "/QCBackend";

$klein = new \Klein\Klein();


/**
 * Use this to see whether if the server is working
 * url: "localhost/test"  or "localhost/QCBackend/test"
 **/
$klein->respond("GET", $base . "/test", function($response){
	$reply = [
		'success' => 'true',
		'msg' => "Everything is alright"
	];

	return json_encode($reply);
});

/**
 * The login feature
 **/
$klein->respond("POST", $base . "/main/login", function($response){
	//Fetch the data sent from client side
	$login_id = $response->param("login_id");
	$password = $response->param("pass");

 	//We set the default reply message
	$reply = [
		'status' => false,
		'reason' => "Sorry, failed to catch the problem."
	];

	//Check login id and password

	/**
 	 * We are going to check the login_id and password
         * and set the $reply['status'] variable accordingly here.
	 */

	return json_encode($reply);
}  );


/**
 * TODO: Remove this code.
 **/
$klein->respond("POST", $base . "/user/create", function($response){
	echo "Hi how are you :)";
	$address = $response->param("address");
});




/**
 * Something bad happened.
 **/
$klein->respond('404', function(){
    $reply = json_encode([
	'success' => 'false',
	'msg' => 'Illegal request'
    ]);
	return $reply;
});


$klein-> dispatch();


?>
