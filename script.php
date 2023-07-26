<?php

$javaClassPath = "Main.class";

// Command to execute the Java class using 'java'
$command = "java -cp $javaClassPath MyJavaFile";

// Execute the Java command and capture the output
exec($command, $output, $returnCode);

// Check the return code to see if the command executed successfully
if ($returnCode === 0) {
    echo "Java file executed successfully!";
    // Process $output array if needed
} else {
    echo "Error executing Java file. Return code: $returnCode";
}
?>

