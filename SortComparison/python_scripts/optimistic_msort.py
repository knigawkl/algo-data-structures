from matplotlib import pyplot;
from pylab import genfromtxt;  
mat0 = genfromtxt("../txt_data/asc_msort.txt");
pyplot.plot(mat0[:,0], mat0[:,1]);
pyplot.legend();
pyplot.title("Sorting almost sorted dataset with MergeSort");
pyplot.xlabel("N");
pyplot.ylabel("t[ns]");
pyplot.title("Sorting almost sorted dataset with MergeSort");
pyplot.xlabel("N");
pyplot.ylabel("t[ns]");
pyplot.show();