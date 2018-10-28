from matplotlib import pyplot;
from pylab import genfromtxt;  
mat0 = genfromtxt("../txt_data/dsc_msort.txt");
pyplot.plot(mat0[:,0], mat0[:,1]);
pyplot.legend();
pyplot.title("Sorting reversed dataset with MergeSort");
pyplot.xlabel("N");
pyplot.ylabel("t[ns]");
pyplot.show();