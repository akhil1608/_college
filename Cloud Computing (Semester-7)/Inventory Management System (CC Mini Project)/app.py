#!/usr/bin/env python

from flask import Flask, request, redirect, flash, render_template
import sys
import optparse
import time
import os

app = Flask(__name__, template_folder='')
app.secret_key = 'some_secret'
start = int(round(time.time()))

@app.route("/")
def home():
    return render_template("home.html")

@app.route("/addCar")
def addCar():
    return render_template("addCar.html")

@app.route("/removeCar")
def removeCar():
    return render_template("removeCar.html")

@app.route("/add",methods=["POST"])
def add():
	car = request.form["car"]
	units = request.form["units"]
	message = update(car,units,"add")
	flash(message)
	return redirect("/addCar")

@app.route("/remove",methods=["POST"])
def remove():
	car = request.form["car"]
	units = request.form["units"]
	message = update(car,units,"remove")
	flash(message)
	return redirect("/removeCar")

@app.route("/inventory")
def inventory():
	i = open("carlist.txt","r")
	arr = []
	for line in i:
		l = line.split(" ")
		arr.append([l[0],int(l[1])])
	i.close()
	return render_template("inventory.html", arr=arr);

def update(c,u,o):
	f = open("carlist.txt","r")
	g = open("carlist_temp.txt","a+")
	m = ""
	for line in f:
		l = line.split(" ")
		car = l[0]
		if(car==c):
			if(o=="add"):
				units = int(u)+int(l[1])
				m = "Cars added to the inventory!"
			else:
				units = int(l[1])-int(u)
				if(units<0):
					m = "Not enough cars to sell!"
					units = int(l[1])
				elif(units==0):
					m = "Cars sold!"
					continue
				else:
					m = "Cars sold!"
			content = car+" "+str(units)+"\n"
			g.write(content)
		else:
			g.write(line)
	if(m==""):
		if(o=="add"):
			content = c+" "+u+"\n"
			g.write(content)
			m = "New set of cars added to the inventory!"
		else:
			m = "Car not found!"
	f.close()
	g.close()
	os.remove("carlist.txt")
	os.rename("carlist_temp.txt","carlist.txt")
	return m

if __name__ == '__main__':
    parser = optparse.OptionParser(usage="python simpleapp.py -p ")
    parser.add_option('-p', '--port', action='store', dest='port', help='The port to listen on.')
    (args, _) = parser.parse_args()
    if args.port == None:
        print "Missing required argument: -p/--port"
        sys.exit(1)
    app.run(host='0.0.0.0', port=int(args.port), debug=False)