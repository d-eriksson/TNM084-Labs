import java.lang.*;

public class DemoShader extends Shader {
	// The result is scaled to stay just inside [-1,1]
	void shader(double[] p, double u, double v, double t) {

		double g1;
		double g2;
		double g3;
		//g1 =  0.5 + 0.5*SimplexNoise.noise((1.0-2*abs((v-0.5))- 2*abs((u-0.5)))*2,(1.0-2*abs((v-0.5))+ 2*abs((u-0.5)))*2, t);
		//g2 = 0.5 + 0.5*SimplexNoise.noise((1.0-2*abs((v-0.5))- 2*abs((u-0.5)))*3,(1.0-2*abs((v-0.5))+2*abs((u-0.5)))*3, t);
		//g3 = 0.5 + 0.5*SimplexNoise.noise((1.0-2*abs((v-0.5))- 2*abs((u-0.5)))*4,(1.0-2*abs((v-0.5))+ 2*abs((u-0.5)))*4, t);
		g1 = 0.75 + 0.25*SimplexNoise.noise(v,u,t*0.05);
		g2 = 0.45 + 0.25*SimplexNoise.noise(v,u,t*0.05);
		g3 = 0.5 + 0.5*SimplexNoise.noise(v*40,u*1, t*0.05);

		if( g3 >= 0.95 || (abs(Math.sin(0.5*t)) >= v-0.1 && abs(Math.sin(0.5*t)) <= v+0.1 && g3 >= 0.70)){
			p[0] = g3;
			p[1] = g3;
			p[2] = g3;
		}
		/*if(g3 >= 0.7 && g3 < 0.90){
			p[0] = g3;
			p[1] = g3;
			p[2] = g3+0.1;
		}*/
		else{
			p[0]=0.0;
			p[1]=g2;
			p[2]=g1;
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
