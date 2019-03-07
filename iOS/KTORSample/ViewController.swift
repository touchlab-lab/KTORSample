//
//  ViewController.swift
//  KTORSample
//
//  Created by Samuel Hill on 3/5/19.
//  Copyright © 2019 Samuel Hill. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController {

    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var resultText: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        DogAPI().getRandomDog {result in
            self.resultText.text = result
            let url = URL(string: result)
            DispatchQueue.global().async {
                let data = try? Data(contentsOf: url!) //make sure your image in this url does exist, otherwise unwrap in a if let check / try-catch
                DispatchQueue.main.async {
                    self.image.image = UIImage(data: data!)
                }
            }
            return KotlinUnit()
        }
    }
}
