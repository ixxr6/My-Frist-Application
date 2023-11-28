package com.jnu.student;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;


public class BaiduMapFrag extends Fragment{

    private MapView mMapView =null;


    public BaiduMapFrag() {
        // Required empty public constructor
    }

    public static BaiduMapFrag newInstance() {
        BaiduMapFrag fragment = new BaiduMapFrag();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_baidumap,container,false);
        mMapView =rootView.findViewById(R.id.bmapView);
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.zoom(18.0f);
        BaiduMap mBaiduMap = mMapView.getMap();
        mMapView.getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        LatLng point1=new LatLng(22.255453,113.54145);

//设置地图中心位置
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(point1);
        mBaiduMap.animateMapStatus(mapStatusUpdate);
//设置地图显示层级
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(15));
//添加图片标记
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.book_2);
        MarkerOptions markerOptions =new MarkerOptions().position(point1).icon(bitmap);
        mBaiduMap.addOverlay(markerOptions);
//添加文字标记
        LatLng point2=new LatLng(22.255453,113.54145);
        TextOptions textOptions =new TextOptions().position(point2).text("Hello Baidu Map");
        mBaiduMap.addOverlay(textOptions);

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(requireContext(),"test",Toast.LENGTH_LONG).show();
                return false;
            }
        });

        return rootView;
    }


    @Override
    public void onResume(){
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}



