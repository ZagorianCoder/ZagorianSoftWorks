from decimal import *
getcontext().prec=2
new_file=open("stats.txt",'w')
text=open("Sacramentorealestatetransactions.csv",'r')
line=text.readline()
line=text.readline()
athroisma=0
trans={}
typ={}
c={}
while line:
	lst=line.split(',')
	if int(lst[6])>=2000:
		athroisma=athroisma+int(lst[9])
	if lst[7] in trans:
		trans[lst[7]]+=1
	else:
		trans[lst[7]]=1	
	if lst[7] not in typ:
		typ[lst[7]]=lst[6]
		c[lst[7]]=1	
	else:
		typ[lst[7]]+=lst[6]
		c[lst[7]]+=1
	line=text.readline()
lst3=list(typ.items())
lst4=list(c.items())
avg={}
for i in range (len(lst3)):
	for j in range (len(lst4)):
		avg[lst3[i][0]]=Decimal(lst3[i][1])/Decimal(lst4[i][1]) 
print(lst3,"\n",lst4)
total_val=str(athroisma)
new_file.write("Total value of transactions of properties at least 2000 sq.f.:"+total_val+"\n")
lst_of_trans=list(trans.items())
new_file.write("Total number of transactions per property type:\n")
for i in range(len(lst_of_trans)):
	new_file.write("\t"+lst_of_trans[i][0]+":\t"+str(lst_of_trans[i][1])+"\n")
average=list(avg.items())
new_file.write("Average size of sold properties per property type:\n")
for i in range(len(average)):
	new_file.write(average[i][0]+": "+str(average[i][1])+"\n")
new_file.close()
