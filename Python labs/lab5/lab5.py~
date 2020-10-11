def decimal_to_roman(n):
	xil=n // 1000
	U=n % 1000
	ek=U // 100
	U=U % 100
	dek=U // 10
	mon=U % 10
	mapping = [['','I','II','III','IV','V','VI','VII','VIII','IX'],
	['','X','XX','XXX','XL','L','LX','LXX','LXXX','XC'],
	['','C','CC','CCC','CD','D','DC','DCC','DCCC','CM'],
	['','M','MM','MMM']]
	if n<=3999:
		roman_num=mapping[3][xil]+mapping[2][ek]+mapping[1][dek]+mapping[0][mon]
	else:
		roman_num=''
	return roman_num
def roman_to_decimal(t):
	if t != '':
		text=t
		text.split()
		rd={'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
		dec_num=0
		for i in range(len(text)):
			if i+1<=len(text)-1:
				if rd[text[i]]<rd[text[i+1]]:
					dec_num+=rd[text[i]]*(-1)
				else:
					dec_num+=rd[text[i]]
			else:
				dec_num+=rd[text[i]]
	return dec_num
		
x=int(input("Insert a number:"))
r=decimal_to_roman(x)
print(r)
print(roman_to_decimal(r))
