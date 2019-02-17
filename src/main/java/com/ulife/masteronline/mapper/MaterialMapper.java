package com.ulife.masteronline.mapper;

import com.ulife.masteronline.pojo.Material;

import java.util.ArrayList;

public interface MaterialMapper {
    public void addMaterial(Material material);
    public ArrayList<Material> getMaterials(int id);
    public ArrayList<Material> getMaterialsByCid(int cid);
    public void deleteMaterial(int id);
    public Material getMaterial(int id);

}
