package com.example.Srping_day10.controller;

import com.example.Srping_day10.entity.ProductEntity;
import com.example.Srping_day10.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/")
   public String getProduct(Model model){
       List<ProductEntity>product = (List<ProductEntity>)productRepository.findAll();
       model.addAttribute("product",product);
       return "product";
   }
   @GetMapping("/edit-product/{id}")
   public String editProduct(@PathVariable int id,Model model){
       Optional<ProductEntity>product=productRepository.findById(id);
       if (product.isPresent()) {
           model.addAttribute("product", product.get());
           return "editProduct";
       } else {
           return "redirect:/";
       }
   }
    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute("product") ProductEntity product) {
        productRepository.save(product);
        return "redirect:/";
    }
    @GetMapping("/delete-cart/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/add-product" )
    public String addProductForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "addProduct";
    }
}
