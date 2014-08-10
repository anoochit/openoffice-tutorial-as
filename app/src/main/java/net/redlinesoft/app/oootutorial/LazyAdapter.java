package net.redlinesoft.app.oootutorial;

import net.redlinesoft.app.oootutorial.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {
	
	private Activity activity;
    private String[][] data;
    
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 
    
    public LazyAdapter(Activity a, String[][] myData) {
        activity = a;
        data=myData;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.activity_column, null);
 
        TextView text = (TextView)vi.findViewById(R.id.ColTitle);
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.ColImage); // thumb image
 
        text.setText(data[position][1]);
        String image_url = "http://i.ytimg.com/vi/"+data[position][2]+"/hqdefault.jpg";    
        imageLoader.DisplayImage(image_url, position, thumb_image);
        return vi;
	}

}
