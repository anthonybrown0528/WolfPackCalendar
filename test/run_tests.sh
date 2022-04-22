#!/bin/bash
java -cp bin WolfPackCalendar
echo "------------- End of Test 0 ------------------------"
java -cp bin WolfPackCalendar XX
echo "------------- End of Test 1 ------------------------"
java -cp bin WolfPackCalendar 2007 yearXX.txt
echo "------------- End of Test 2 ------------------------"
java -cp bin WolfPackCalendar 2007 test-files/year2007.txt
echo "------------- End of Test 3 ------------------------"
java -cp bin WolfPackCalendar 2022 test-files/year2022.txt
echo "------------- End of Test 4 ------------------------"
java -cp bin WolfPackCalendar 2007 test-files/year2008.txt
echo "------------- End of Test 5 -----------------------"
java -cp bin WolfPackCalendar -33
echo "------------- End of Test 6 ------------------------"
java -cp bin WolfPackCalendar 2025
echo "------------- End of Test 7 ------------------------"
java -cp bin WolfPackCalendar 2020
echo "------------- End of Test 8 ------------------------"
java -cp bin WolfPackCalendar 2007 test-files/year2007.txt thirdargument
echo "------------- End of Test 9 ------------------------"