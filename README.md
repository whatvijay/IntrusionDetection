Java , Spring based tool which can be accessed via web page .It accepts log file as input analyzes and delivers any exceptions , login failures, Malicious inputs , role mismatch in logs as output.

1)  File is accepted as input by spring controller(launch http://localhost:9010/Index.html)
2) File is converted to a string or string array
3) We check for any exceptions , login failure , response codes etc key words and finally segregate them and return the output
4) We can pass this json out put to any further analysis.

Ensure Java 8 on class path and run LogbasedintrusiondetectionApplication