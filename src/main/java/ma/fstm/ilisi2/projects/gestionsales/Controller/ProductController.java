package ma.fstm.ilisi2.projects.gestionsales.Controller;


import ma.fstm.ilisi2.projects.gestionsales.Model.bo.Product;
import ma.fstm.ilisi2.projects.gestionsales.Model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sales")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> listProducts = productService.listAll();
        model.addAttribute("listProducts",listProducts);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/sales/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Optional<Product> product = productService.get(id);

        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/sales/";
    }



}
