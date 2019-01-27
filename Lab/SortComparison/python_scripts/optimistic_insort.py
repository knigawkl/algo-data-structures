from matplotlib import pyplot;
from pylab import genfromtxt;  
mat0 = genfromtxt("../txt_data/asc_insort.txt");
pyplot.plot(mat0[:,0], mat0[:,1]);
pyplot.legend();
pyplot.title("Sorting almost sorted dataset with InsertionSort");
pyplot.xlabel("N");
pyplot.ylabel("t[ns]");
pyplot.show();