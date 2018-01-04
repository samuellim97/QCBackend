<?php
require_once __DIR__ . '/vendor/autoload.php';
$base = "/QCBackend";

$klein = new \Klein\Klein();


$klein->respond($base,function(){
    print(json_encode([
	'success' => 'false',
	'msg' => 'Illegal request'
    ]));
	return 'hello world';
});

$klein->respond("POST", $base . "/user/create", function($response){
	echo "Hi how are you :)";
	$address = $response->param("address");
});

$klein-> dispatch();


?>
