<?php
require_once __DIR__ . '/vendor/autoload.php';


$klein = new \Klein\Klein();


$klein->respond(function(){
    print(json_encode([
	'success' => 'false',
	'msg' => 'Illegal request'
    ]));
	return 'hello world';
});
$klein-> dispatch();

?>
