package com.example.demo.idemo.anim;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseActivity;

public class CircleImageActivity extends BaseActivity implements View.OnClickListener {

    private RoundView roundView;
    private String url[] = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789242366&di=ae0a7b638fe5d7f17907ef6b2802966d&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201504%2F15%2F20150415H5703_nusHC.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789242365&di=af34eaa9f2027539717d0f91d37a159a&imgtype=0&src=http%3A%2F%2Fent.taiwan.cn%2Flist%2F201505%2FW020150512358765490025.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789242364&di=98a58211c76770e09f7823a9047ac195&imgtype=0&src=http%3A%2F%2Fwww.cnxmld.com%2Ftupians%2Fbd13348198.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789242364&di=79e8fc9a297161c4831b792a257eef05&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201407%2F31%2F20140731202921_Qudzv.thumb.700_0.png",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789242367&di=c57c778536d1d39a8016c92f7668fec8&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3D66ece731402309f7e73aa516473e20c5%2Ffaedab64034f78f0de9068567f310a55b2191cff.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495789242362&di=5f428d95ef240c71bbf9fcf01fc468ab&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201503%2F05%2F20150305192547_Tewcf.jpeg"};
    private int index;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image);
        iv = (ImageView) findViewById(R.id.iv);
        Glide.with(this).load("http://test.image.youcume.com/sq/circle/2017/05/26/13/b759f0cb-aa25-4115-bbc8-000a6cb5e4e4429_h960_w1280_e_b_1.jpg").into(iv);
        roundView = (RoundView) findViewById(R.id.round);
        roundView.setOuterColor(Color.YELLOW);
        roundView.setOnClickListener(this);
        roundView.setImageUrl("http://test.image.youcume.com/sq/circle/2017/05/26/13/b759f0cb-aa25-4115-bbc8-000a6cb5e4e4429_h960_w1280_e_b_1.jpg");
    }

    @Override
    public void onClick(View v) {
        roundView.setImageUrl(url[index]);
        index++;
        if (index == url.length) {
            index = 0;
        }
    }
}
