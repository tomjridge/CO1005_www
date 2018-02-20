all:
	./upload.sh

# https://www.digitalocean.com/community/tutorials/how-to-find-broken-links-on-your-website-using-wget-on-debian-7
check_links:
	wget --spider -r -nd -nv -H -l 3 -o run1.log  http://www.cs.le.ac.uk/people/tr61/CO1005_2018q1/www/



# http://www.createdbypete.com/articles/simple-way-to-find-broken-links-with-wget/
#	wget --spider -o ~/wget.log -e robots=off -w 1 -r -p http://www.example.com
