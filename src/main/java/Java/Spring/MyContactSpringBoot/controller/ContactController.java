package Java.Spring.MyContactSpringBoot.controller;

import Java.Spring.MyContactSpringBoot.entity.Contact;
import Java.Spring.MyContactSpringBoot.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping({"/contact","/"})
    public String list(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "list";
    }

    @GetMapping("/contact/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/contact";
        }
        model.addAttribute("contacts", contactService.search(term));
        return "list";
    }

    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return "form";
    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }

    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/contact";
    }

//    @GetMapping("getListProductByPage")
//    public String getListProductByPage(@RequestParam Integer productStart, ModelMap modelMap) {
//
//        Page<Contact> page = contactService.page();
//        List<ProductEntity> listproduct = productService.getListAllAndLimit(productStart);
//        List<ProductEntity> productEntityListAll = productService.getListAllAndLimit(-1);
//        double totalPage = Math.ceil((double) productEntityListAll.size() / 2);
//        modelMap.addAttribute("totalPage", totalPage);
//        modelMap.addAttribute("listproduct", listproduct);
//
//        List<CatalogEntity> catalogEntities = catalogService.getListAll();
//        modelMap.addAttribute("listCatalog", catalogEntities);
//
//        return "addproduct";
//    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }


}
