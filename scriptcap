#! /bin/sh

function mng {
	clear
	echo $*
	echo "use mongojpa\n$*" | mongo | grep -v MongoDB | grep -v bye | grep -v "connecting to" | grep -v "switched to" | grep -v "use mongojpa"
}

rm -f jpa.out
psql mongojpa -t -c "\dt"  | cut -d\| -f2 | while read LINE
do
	echo "Table: $LINE\n" >> jpa.out
	psql mongojpa -c "select * from $LINE" 2>/dev/null >> jpa.out
done

mvn test
rm -f /tmp/scripted
COUNT=1
ack "  \*" /Users/jlee/personal/dev/presos/mongo4JpaDevs/presentation/script | cut -c5- | while read LINE
do
	mng ${LINE}
	sleep 1
	screencapture -x -a -o presentation/images/page${COUNT}.png 2> /dev/null
	TEXT=${LINE//.limit(2)/}
	TEXT=${TEXT//.pretty()/}
	echo "<section><code>${TEXT}</code><img src='images/page${COUNT}.png'></section>\n\n" >> /tmp/scripted
	COUNT=$[ $COUNT + 1 ]
	echo
done

rm -f presentation/scripted.html
cat presentation/index.html | while read LINE
do
	if [ "${LINE// /}" != "<!--scripted-->" ]
	then
		echo "$LINE" >> presentation/scripted.html
	else
		cat /tmp/scripted >> presentation/scripted.html
	fi
done

sed -e 's/ class="fragment .*">/>/' presentation/scripted.html | tee presentation/printable.html
