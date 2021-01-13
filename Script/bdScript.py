import json

with open('estados.json') as f:
  edos = json.load(f)

with open('estados-municipios.json') as f:
  mpos = json.load(f)

script = ''

idMun = 1;

for i in range(0, len(edos)):
  script += '/*' + edos[i]["nombre"].upper() + '*/\n'
  script += 'call spInsertarEntidadFederativa('+ str(i+1) +', \''+ edos[i]["nombre"] + '\', \''+ edos[i]["clave"]+'\');\n\n'
  edo = mpos[edos[i]["nombre"]];
  for j in range(0, len(edo)):
    script += 'call spInsertarMunicipio(\''+str(idMun)+'\', '+str(i+1)+', \''+edo[j]+'\');\n'
    idMun += 1
  script += '\n\n'

f = open("../llenarBase.sql", "w")
f.write(script)
f.close()
