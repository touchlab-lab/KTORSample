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
            return KotlinUnit()
        }
    }
}
