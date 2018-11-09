public class DemoShader0 extends Shader {
	// The result is scaled to stay just inside [-1,1]
	void shader(double[] p, double u, double v, double t) {

		double g1;
		double g2;
		double g3;
		//g1 =  0.5 + 0.5*SimplexNoise.noise((1.0-2*abs((v-0.5))- 2*abs((u-0.5)))*2,(1.0-2*abs((v-0.5))+ 2*abs((u-0.5)))*2, t);
		//g2 = 0.5 + 0.5*SimplexNoise.noise((1.0-2*abs((v-0.5))- 2*abs((u-0.5)))*3,(1.0-2*abs((v-0.5))+2*abs((u-0.5)))*3, t);
		//g3 = 0.5 + 0.5*SimplexNoise.noise((1.0-2*abs((v-0.5))- 2*abs((u-0.5)))*4,(1.0-2*abs((v-0.5))+ 2*abs((u-0.5)))*4, t);
		g1 = 0.6 + 0.4*SimplexNoise.noise(v*4,u*4,t);
		g2 = 0.3 + 0.1*SimplexNoise.noise(2*abs(v-0.5) - 2*abs(u*v-0.5),u*4,t);
		g3 = 0.5 + 0.5*SimplexNoise.noise(v*35,u*35,0.0);
		if(g3 >= t*0.1){
			p[0] = 1.0;
			p[1] = 1.0;
			p[2] = 1.0;
		}
		/*if(g3 >= 0.7 && g3 < 0.90){
			p[0] = g3;
			p[1] = g3;
			p[2] = g3+0.1;
		}*/
		else{
			p[0]=g1;
			p[1]=g2;
			p[2]=0.0;
		}
	}
	double abs(double x){
		if(x>=0.0){
			return x;
		}
		else{
			return -1*x;
		}
	}

}
