<?php

$javaClassPath = "Main.class";
$targetDownload = "download.html";
$command = "java -cp /var/www/html/km6sqn/java/out/production/java/ Main";

// Execute the Java command and capture the output
exec($command, $output, $returnCode);

// Check the return code to see if the command executed successfully
if ($returnCode === 0) {
     echo "File Uploaded.  Redirecting...";
          header("Location: $targetDownload");
          exit();
    // Process $output array if needed
} else {
    echo "Error executing Java file. Return code: $returnCode";
}
?>

